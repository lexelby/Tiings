package tilingTypes.P5;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeP5_03
   extends TilingType
{
   public TilingTypeP5_03(){
      super( "P5-3: Type 1&2", 5, SymmetryType.pg );

      paramMin = new int[]{  0,  0,  0};
      paramMax = new int[]{180,100,100};
      paramDef = new int[]{ 60, 55, 30};
      paramName = new String[]{ "Angle", "Aspect", "Relative Length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 0,1, 0,3,4, 1},
            };
      info = "b=e\nc=a+d\nA+B=180\nB=D\n(C+D+E=360)";
   }

   public void recalcBase(double[] paramValues) {
      double h = 2*paramValues[1]/100.;
      double w = 2-h;
      double f = paramValues[2]/100.;
      double c = h*Math.cos( (paramValues[0]) * DEG2RAD);
      double s = h*Math.sin( (paramValues[0]) * DEG2RAD);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,  w - f*c, -f*s);
      baseTile.setPoint(2, w + (1-f)*c, (1-f) * s);
      baseTile.setPoint(3, w + c*(1-f-f), s );
      baseTile.setPoint(4, (1-f)*c, (1-f)*s);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[0].getX(4);
      offsets[1] = tiles[0].getY(2)-tiles[0].getY(4);
      offsets[2] = tiles[1].getX(3)-tiles[0].getX(0);
      offsets[3] = tiles[1].getY(3)-tiles[0].getY(0);
   }
}
