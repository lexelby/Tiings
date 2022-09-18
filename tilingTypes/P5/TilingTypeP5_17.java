package tilingTypes.P5;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeP5_17
	extends TilingType
{
	public TilingTypeP5_17(){
		super( "P5-17&21: Type 1, Pentagon zipper pattern", 5, SymmetryType.cm );
		// params are angle/distance of the other three points relative to first one
		paramMin = new int[]{  0,  0,-89};
		paramMax = new int[]{180,100, 89};
		paramDef = new int[]{ 60, 30, 20};
		paramName = new String[]{ "Angle", "Relative Length", "Angle 2" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 3,4, 0,2,3, 1},
            };
      info = "a=c\nd=e\nA+B=180\n(C+D+E=360)";
   }

   public void recalcBase(double[] paramValues) {
      double h = 1.5*paramValues[1]/100.;
      double w = 1.5-h;
      double t = w*Math.tan( paramValues[2]* DEG2RAD)/2;
      double s = h*Math.sin( paramValues[0]* DEG2RAD);
      double c = h*Math.cos( paramValues[0]* DEG2RAD);
      baseTile.setPoint(0,   0,  0);
      baseTile.setPoint(1,   w,  0);
      baseTile.setPoint(2, w-c,  s);
      baseTile.setPoint(3,w/2-c,s+t);
      baseTile.setPoint(4,  -c,  s);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[1].getX(0)-tiles[0].getX(0);
      offsets[1] = tiles[1].getY(0)-tiles[0].getY(0);
      offsets[2] = tiles[0].getX(1)-tiles[0].getX(0);
      offsets[3] = tiles[0].getY(1)-tiles[0].getY(0);
   }
}
