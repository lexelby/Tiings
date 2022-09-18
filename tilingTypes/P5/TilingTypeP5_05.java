package tilingTypes.P5;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeP5_05
	extends TilingType
{
	public TilingTypeP5_05(){
		super( "P5-5&18: Type 1, Pentagon strip pattern", 5, SymmetryType.p2 );
		// params are angle/distance of the other three points relative to first one
		paramMin = new int[]{  0,  0,  0,  0,  0};
		paramMax = new int[]{180,100,180,100,100};
		paramDef = new int[]{ 70, 40,135, 45, 30};
		paramName = new String[]{ "Angle", "Aspect", "Angle 2", "Relative Length", "Offset" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 2,3, 0,3,2, 0},
            };
      info = "a=c\nA+B=180\n(C+D+E=360)";
   }

   public void recalcBase(double[] paramValues) {
      double ln2 = 2*paramValues[1]/100.;
      double w = 2-ln2;
      double ln3 = ln2*getParam( paramValues,3)/100.;
      ln2 -= ln3;
      double x4 = -ln2 * Math.cos( paramValues[0] * DEG2RAD);
      double y4 = ln2 * Math.sin( paramValues[0] * DEG2RAD);
      double x3 = x4+w+ ln3 * Math.cos( (paramValues[0]+paramValues[2]) * DEG2RAD);
      double y3 = y4 - ln3 * Math.sin( (paramValues[0]+paramValues[2]) * DEG2RAD);
      
      baseTile.setPoint(0,   0,  0);
      baseTile.setPoint(1,   w,  0);
      baseTile.setPoint(2,w+x4, y4);
      baseTile.setPoint(3,  x3, y3);
      baseTile.setPoint(4,  x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      double os = paramValues[4]/100.;
      offsets[0] = tiles[0].getX(1)-tiles[0].getX(0);
      offsets[1] = tiles[0].getY(1)-tiles[0].getY(0);
      offsets[2] = tiles[1].getX(0)*(1-os)+tiles[1].getX(1)*os-tiles[0].getX(0);
      offsets[3] = tiles[1].getY(0)*(1-os)+tiles[1].getY(1)*os-tiles[0].getY(0);
   }
}
