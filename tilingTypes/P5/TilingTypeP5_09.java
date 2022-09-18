package tilingTypes.P5;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeP5_09
	extends TilingType
{
	public TilingTypeP5_09(){
		super( "P5-9&20&21: Type 1, Pentagon zipper pattern mirrored", 6, SymmetryType.pgg );
		// params are angle/distance of the other three points relative to first one
		paramMin = new int[]{  0,  0,-89,  0};
		paramMax = new int[]{180,100, 89,100};
		paramDef = new int[]{ 60, 30, 20, 30};
		paramName = new String[]{ "Angle", "Relative Length", "Angle 2", "Offset" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 4,5, 0,3,4, 1},
            {0, 1,2, 1,2,1, 1},
            {0, 4,5, 2,3,4, 0},
            };
      labels = new int[]{0,-1,1,2,3,4};
      info = "a=c\nd=e\nA+B=180\n(C+D+E=360)";
   }

   public void recalcBase(double[] paramValues) {
      double h = 1.5*paramValues[1]/100.;
      double w = 1.5-h;
      double os = w*getParam( paramValues,3)/100.;
      double t = w*Math.tan( paramValues[2]* DEG2RAD)/2;
      double s = h*Math.sin( paramValues[0]* DEG2RAD);
      double c = h*Math.cos( paramValues[0]* DEG2RAD);
      baseTile.setPoint(0,   0,  0);
      baseTile.setPoint(1,  os,  0);
      baseTile.setPoint(2,   w,  0);
      baseTile.setPoint(3, w-c,  s);
      baseTile.setPoint(4,w/2-c,s+t);
      baseTile.setPoint(5,  -c,  s);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[3].getX(1)-tiles[0].getX(0);
      offsets[1] = tiles[3].getY(1)-tiles[0].getY(0);
      offsets[2] = tiles[0].getX(2)-tiles[0].getX(0);
      offsets[3] = tiles[0].getY(2)-tiles[0].getY(0);
   }
}
