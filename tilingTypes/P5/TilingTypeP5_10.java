package tilingTypes.P5;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeP5_10
	extends TilingType
{
	public TilingTypeP5_10(){
		super( "P5-10&11: Type 2 - Generic", 5, SymmetryType.pgg );
 
		paramMin = new int[]{   0,  0,  0,  0};
		paramMax = new int[]{ 180,500,100,180};
		paramDef = new int[]{  90,100, 50, 36};
		paramName = new String[]{ "Angle 1", "Relative Length", "Relative Length 2", "Angle 2" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 3,4, 0,1,2, 1},
            {0, 2,3, 0,0,1, 1},
            {0, 1,2, 2,3,4, 0},
            };
      info = "c=e\nB+D=180\n(A+C+E=360)";
   }

   public void recalcBase(double[] paramValues) {
      double ln2 = paramValues[1]/100.;
      double f = getParam( paramValues,2)/100.;

      double x2 = ln2 * Math.cos( paramValues[0] * DEG2RAD);
      double y2 = ln2 * Math.sin( paramValues[0] * DEG2RAD);
      double x1 = (x2 + 1)*f;
      double y1 = y2*f;
      double x4 = x2 - Math.cos( (paramValues[0]-paramValues[3]) * DEG2RAD);
      double y4 = y2 - Math.sin( (paramValues[0]-paramValues[3]) * DEG2RAD);
      double ln4 = (1-f)*Math.sqrt((x2 + 1)*(x2 + 1) + y2*y2);
      double ang1 = Math.atan2(y2,x2 + 1)/DEG2RAD;
      double x3 = x2 - ln4 * Math.cos( (paramValues[0]-paramValues[3]-ang1) * DEG2RAD);
      double y3 = y2 - ln4 * Math.sin( (paramValues[0]-paramValues[3]-ang1) * DEG2RAD);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[3].getX(4)-tiles[0].getX(0);
      offsets[1] = tiles[3].getY(4)-tiles[0].getY(0);
      offsets[2] = tiles[0].getX(2)-tiles[2].getX(0);
      offsets[3] = tiles[0].getY(2)-tiles[2].getY(0);
   }
}
