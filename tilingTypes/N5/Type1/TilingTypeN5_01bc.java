package tilingTypes.N5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN5_01bc
   extends TilingType
{
   public TilingTypeN5_01bc(){
      super( "N5-1bc: type 1&2", 5, SymmetryType.p2 );

      paramMin = new int[]{  0,  0,  0};
      paramMax = new int[]{180,100,100};
      paramDef = new int[]{ 70, 30, 30};
      paramName = new String[]{ "Angle", "Aspect", "Relative Length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 0,1, 0,1,0, 0},
            {1, 0,1, 0,3,4, 1},
            {1, 0,1, 1,3,4, 1},
            };
      info = "b=e\nc=a+d\nA+B=180\nB=D\n(C+D+E=360)";
   }

   public void recalcBase(double[] paramValues) {
      double h = 2*paramValues[1]/100.;
      double w = 2-h;
      double f = getParam(paramValues,2)/100.;
      double c = h*Math.cos( (paramValues[0]) * DEG2RAD);
      double s = h*Math.sin( (paramValues[0]) * DEG2RAD);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,  w - f*c, -f*s);
      baseTile.setPoint(2, w + (1-f)*c, (1-f) * s);
      baseTile.setPoint(3, w + c*(1-f-f), s );
      baseTile.setPoint(4, (1-f)*c, (1-f)*s);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(4)-tiles[0].getX(2);
      offsets[1] = tiles[0].getY(4)-tiles[0].getY(2);
      offsets[2] = tiles[2].getX(3)-tiles[3].getX(4);
      offsets[3] = tiles[2].getY(3)-tiles[3].getY(4);
   }
}
